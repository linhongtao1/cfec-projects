<template>
  <div class="container">
    <!-- 添加用户模态框 -->
    <el-dialog :title="title" :visible.sync="dialogVisible" width="50%" :before-close="handleClose">

      <el-form ref="form" :model="addUserform" label-width="120px" :inline="true">
        <el-form-item label="学号">
          <el-input v-model="addUserform.code" />
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="addUserform.name" />
        </el-form-item>
        <el-form-item label="身份证号码">
          <el-input v-model="addUserform.idCode" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="addUserform.gender" placeholder="请选择性别" size="130px">
            <el-option label="男" value="男" />
            <el-option label="女" value="女" />
          </el-select>
        </el-form-item>
        <el-form-item label="联系方式">
          <el-input v-model="addUserform.phone" />
        </el-form-item>
        <el-form-item label="家庭住址">
          <el-input v-model="addUserform.address" />
        </el-form-item>
        <el-form-item label="监护人姓名">
          <el-input v-model="addUserform.guardianName" />
        </el-form-item>
        <el-form-item label="监护人联系方式">
          <el-input v-model="addUserform.guardianPhone" />
        </el-form-item>
        <el-form-item label="备注">
          <el-input v-model="addUserform.memo" />
        </el-form-item>
        <el-form-item label="班级">
          <el-select v-model="addUserform.lessonId" placeholder="班级">
            <el-option v-for="(item) in lessonList" :key="item.id" :label="item.className" :value="item.id" />
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button type="primary" @click="dialogVisibleYes">确 定</el-button>
      </span>
    </el-dialog>

    <el-form :inline="true" class="demo-form-inline">
      <el-button type="primary" @click="dialogVisible = true">添加学生</el-button>

      <el-form-item label="学院">
        <el-select v-model="oneDept.id" placeholder="学院" @change="getTwoDeptList(oneDept.id)">
          <el-option v-for="(item) in oneDept" :key="item.id" :label="item.name" :value="item.code" />
        </el-select>
      </el-form-item>
      <el-form-item label="专业">
        <el-select v-model="twoDept.code" placeholder="专业" @change="getLessonByDept(twoDept.code)">
          <el-option v-for="(item) in twoDept" :key="item.id" :label="item.name" :value="item.code" />
        </el-select>
      </el-form-item>
      <el-form-item label="班级">
        <el-select v-model="lessonList.id" placeholder="班级" @change="loadStudentList(lessonList.id)">
          <el-option v-for="(item) in lessonList" :key="item.id" :label="item.className" :value="item.id" />
        </el-select>
      </el-form-item>
    </el-form>

    <el-card>
      <!-- 用户列表区域 -->
      <el-table :data="rightsList.slice((currentPage-1)*pagesize,currentPage*pagesize)" border stripe highlight-current-row>
        <el-table-column label="序号" type="index" align="center" width="60" />
        <el-table-column label="账号" prop="username" width="100" align="center" />
        <el-table-column label="密码" prop="password" align="center" />
        <el-table-column label="学号" prop="code" width="100" align="center" />
        <el-table-column label="姓名" prop="name" width="100" align="center" />
        <el-table-column label="性别" prop="gender" width="50" align="center" />
        <el-table-column label="身份证号" prop="idCode" align="center" />
        <el-table-column label="联系方式" prop="phone" width="110" align="center" />
        <el-table-column label="监护人姓名" prop="guardianName" width="120" align="center" />
        <el-table-column label="监护人联系方式" prop="guardianPhone" width="120" align="center" />
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.row.stuId)"
            >编辑</el-button>
            <template>
              <el-button size="mini" type="danger" @click="handleDelete(scope.row.stuId)">删除</el-button>
            </template>
          </template>
        </el-table-column>
      </el-table>

      <!--分页区域-->
      <el-pagination
        :current-page="currentPage"
        :page-sizes="[2,5,10,20,30]"
        :page-size="pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="rightsList.length"
        @size-change="size_change"
        @current-change="current_change"
      />
    </el-card>
  </div>
</template>

<script>
import { getList, saveStudentUser, deleteStudentUser } from '@/api/student'
import { getOneDept, getTwoDept } from '@/api/dept'
import { getLessonByDept } from '@/api/lesson'

export default {
  data() {
    return {
      rightsList: [], // 列表数据
      total: 0, // 总条目数
      pagesize: 10, // 每页显示条目个数
      currentPage: 1, // 当前页数
      title: ' ', // 弹出层标题
      dialogVisible: false, // 是否显示弹出层
      formInline: {
        user: '',
        region: ''
      },
      oneDept: [
        {
          id: '',
          cide: '',
          name: '',
          memo: '',
          deleted: ''
        }
      ],
      twoDept: [],
      lessonList: [],
      addUserform: {
        id: 0,
        userId: 0,
        code: '',
        name: '',
        phone: '',
        address: '',
        guardianName: '',
        guardianPhone: '',
        idCode: '',
        memo: '',
        lessonId: ''
      }
    }
  },
  created() {
    this.loadStudentList(1)
    this.loadOneDeptList()
  },
  methods: {
    // 取消弹窗
    handleClose() {
      this.dialogVisible = false
    },
    // 弹窗确定
    dialogVisibleYes() {
      this.dialogVisible = false
      saveStudentUser(this.addUserform).then(response => {
        this.addUserform = []
        this.loadStudentList(1)
      })
      this.$message({
        type: 'success',
        message: '添加成功！'
      })
    },
    loadStudentList(lessonId) {
      getList(this.currentPage, this.pagesize, lessonId).then(response => {
        this.rightsList = response.data.records
        this.list = response.data.items
      })
    },
    getLessonByDept(code) {
      getLessonByDept(code).then(response => {
        this.lessonList = response.data
      })
    },
    loadOneDeptList() {
      getOneDept().then(response => {
        this.oneDept = response.data
      })
    },
    getTwoDeptList(code) {
      this.lessonList = []
      getTwoDept(code).then(response => {
        this.twoDept = response.data
      })
    },
    handleDelete(stuId) {
      this.stuId = stuId
      this.$confirm('此操作将永久删除该学生, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteStudentUser(this.stuId).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.loadStudentList(this.lessonList.id)
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleEdit() {

    },
    // 监听 pagesize 改变的事件
    size_change(newSize) {
      this.pagesize = newSize
    },
    // 监听 页码值 改变的事件
    current_change(newPage) {
      this.currentPage = newPage
    }
  }
}
</script>
<style scoped>
.container{
  text-align: center;
  margin-top: 15px;
}
.el-form .el-button{
  position: relative;
  left: -200px;
}
</style>
