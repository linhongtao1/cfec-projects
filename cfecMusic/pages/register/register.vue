<template>
	<view class="register">
		<musichead title="注册" :icon="true" color="black"></musichead>
		<view class="container">
			<scroll-view scroll-y="true">
				<form action="">
					<input type="number" placeholder="请输入手机号" maxlength="11">
					<input type="number" placeholder="请输入验证码" maxlength="6">
					<input type="text" placeholder="请输入密码" maxlength="20">
				</form>
			</scroll-view>
		</view>
	</view>
</template>

<script>
	import '@/common/iconfont.css'
	import musichead from '../../components/musichead/musichead.vue'
	export default {
		data() {
			return {

			}
		},
		components: {
			musichead
		},
		methods: {



		}
	}
</script>

<style scoped>
	.register {
		height: 100vh;
		background: rgb(232, 225, 241);
	}
</style>
