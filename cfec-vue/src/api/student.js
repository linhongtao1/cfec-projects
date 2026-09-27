import request from '@/utils/request'

export function getList(pageNum, pageSize, lessonId) {
  return request({
    url: '/student/stuPage?pageNum=' + pageNum + '&pageSize=' + pageSize + '&lessonId=' + lessonId,
    method: 'get'
  })
}

export function saveStudentUser(from) {
  return request({
    url: '/student/saveStudentUser',
    method: 'post',
    data: from
  })
}

export function deleteStudentUser(code) {
  return request({
    url: '/student/deleteStudentUser/' + code,
    method: 'delete'
  })
}
