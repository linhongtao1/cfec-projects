import request from '@/utils/request'

export function getOneDept() {
  return request({
    url: '/dept/oneDept',
    method: 'get'
  })
}

export function getTwoDept(code) {
  return request({
    url: '/dept/twoDept/' + code,
    method: 'get'
  })
}
