import request from '@/utils/request'

// 查询用户历史操作记录图列表
export function listHistory(query) {
  return request({
    url: '/ai/history/list',
    method: 'get',
    params: query
  })
}

// 查询用户历史操作记录图详细
export function getHistory(id) {
  return request({
    url: '/ai/history/' + id,
    method: 'get'
  })
}

// 新增用户历史操作记录图
export function addHistory(data) {
  return request({
    url: '/ai/history',
    method: 'post',
    data: data
  })
}

// 修改用户历史操作记录图
export function updateHistory(data) {
  return request({
    url: '/ai/history',
    method: 'put',
    data: data
  })
}

// 删除用户历史操作记录图
export function delHistory(id) {
  return request({
    url: '/ai/history/' + id,
    method: 'delete'
  })
}
