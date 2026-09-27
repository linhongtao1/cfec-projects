<template>
	<view class="index">
		<view class="container">
			<scroll-view scroll-y="true">
				<view class="index-logo">
					<image src="../../static/logo.png" mode=""></image>云音悦
				</view>
				<view class="index-login">
					<button>手机号登录</button>
					<button>立即注册</button>
				</view>
				<view class="index-other-login">
					<text class="index-other-login-text">——————— 其他登录方式 ———————</text>
					<text class="iconfont icon-shejiaotubiao-39" style="color: rgb(76,175,233);"></text>
					<text class="iconfont icon-weixindenglu" style="color: rgb(0,200,0);"></text>
				</view>
			</scroll-view>
		</view>
	</view>
</template>

<script>
	import '@/common/iconfont.css'
	import musichead from '../../components/musichead/musichead.vue'
	import mForSkeleton from "@/components/m-for-skeleton/m-for-skeleton";
	export default {
		data() {
			return {
			}
		},
		components: {
			musichead,
		},
		onLoad() {

		},
		methods: {
		}
	}
</script>

<style scoped>
	@font-face {
		font-family: 'miaozi';
		src: url('~@/common/miaozidongningti-regular.ttf')
	}

	.index {
		background-image: linear-gradient(#cca2f8, #8357de);
		height: 100vh;
	}

	.index-logo {
		margin-top: 300rpx;
		display: flex;
		flex-direction: column;
		align-items: center;
		font-family: miaozi;
		color: white;
		font-size: 50rpx;
		margin-bottom: 200rpx;
	}

	.index-logo image {
		width: 200rpx;
		height: 200rpx;
		border-radius: 100%;
		border: 8rpx solid #8357de;
	}

	.index-login button {
		margin-bottom: 50rpx;
		width: 600rpx;
		border-radius: 100rpx;
		background: rgba(255, 255, 255, 0.5);
		border: 1px solid white;
		font-size: 28rpx;
		color: white;
		
	}

	.index-other-login {
		text-align: center;
		color: white;
	}

	.index-other-login text:nth-child(1) {
		margin-bottom: 150rpx;
	}

	.index-other-login text:nth-child(2) {
		margin-right: 30rpx;
		font-size: 70rpx;
	}

	.index-other-login text:nth-child(3) {
		margin-right: 30rpx;
		font-size: 65rpx;
	}
</style>
