import request from '@/utils/request'

export function getLessonByDept(code) {
  return request({
    url: '/lesson/byDept/' + code,
    method: 'get'
  })
}
