<template>
  <div>
    <el-upload
        :headers="headers"
        :action="uploadAction"
        class="avatar-uploader"
        :before-upload="beforeUpload"
        :on-remove="handleRemove"
        :on-success="handleUploadSuccess"
        :on-exceed="handleExceed"
        :auto-upload="true"
        :show-file-list="false">
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
<!--    <el-dialog :visible.sync="dialogVisible">-->
<!--      <img width="100%" :src="dialogImageUrl" alt="">-->
<!--    </el-dialog>-->
  </div>
</template>
<script>
import { getToken } from '@/utils/auth'

export default {
  name: 'SingleUpload',
  props: {
    fileType: String,
    value: String
  },
  data() {
    return {
      headers: {Authorization: "Bearer " + getToken()},
      uploadAction: process.env.VUE_APP_BASE_API + "/common/upload",
      // dialogVisible: false,
      // dialogImageUrl:''
    }
  },
  computed: {
    imageUrl: {
      get() {
        return this.value
      },
      set(val) {
      }
    }
  },
  methods: {
    emitInput(val) {
      this.$emit('input', val)
    },
    handleRemove(file, fileList) {
      this.emitInput(fileList)
    },
    beforeUpload(file) {

    },
    handleUploadSuccess(response, file) {
      let url = response.url
      this.imageUrl = url
      this.emitInput(url)
    },
    handleExceed(files, fileList) {
      this.$message({
        message: '最多只能上传' + this.maxCount + '张图片',
        type: 'warning',
        duration: 1000
      })
    },
    // handleCardPreview(file){
    //   this.dialogImageUrl = file.url;
    //   this.dialogVisible = true;
    // }
  }
}
</script>
<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 148px;
  height: 148px;
  line-height: 146px;
  text-align: center;
}

.avatar {
  width: 148px;
  height: 148px;
  display: block;
}
</style>
