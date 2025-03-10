import request from '@/utils/request'

// 查询积分详情图列表
export function listScore(query) {
  return request({
    url: '/ai/score/list',
    method: 'get',
    params: query
  })
}

// 查询积分详情图详细
export function getScore(userId) {
  return request({
    url: '/ai/score/' + userId,
    method: 'get'
  })
}

// 新增积分详情图
export function addScore(data) {
  return request({
    url: '/ai/score',
    method: 'post',
    data: data
  })
}

// 修改积分详情图
export function updateScore(data) {
  return request({
    url: '/ai/score',
    method: 'put',
    data: data
  })
}

// 删除积分详情图
export function delScore(userId) {
  return request({
    url: '/ai/score/' + userId,
    method: 'delete'
  })
}
// 积分总和
export function queryScore(data) {
  return request({
    url: '/ai/score/getUserScore',
    method: 'post',
    data: data
  })
}
