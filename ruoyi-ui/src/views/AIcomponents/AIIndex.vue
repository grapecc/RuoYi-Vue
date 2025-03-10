<template>
  <div class="app-container">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="3">剩余积分</el-menu-item>
      <el-menu-item index="2">历史记录</el-menu-item>
      <el-menu-item index="1">AI生图</el-menu-item>
    </el-menu>

<!--    卡片进行切换-->
    <el-card class="box-card">
      <div v-show=" activeIndexCard == '1'">
        <el-container>
<!--          AI主屏幕内容-->
          <el-main class="aiMain">
<!--          引导说明图-->
            <el-timeline>
              <el-timeline-item
                v-for="(activity, index) in activities"
                :key="index"
                :icon="activity.icon"
                :type="activity.type"
                :color="activity.color"
                :size="activity.size"
                :timestamp="activity.timestamp">
                <el-card>
                  <!--            上传原图图片预览-->
                  <single-upload  v-if = "index == 0"  v-model="form.picRealObj"  ></single-upload>
                  <!--                 物料图上传-->
                  <single-upload v-if = "index == 1" v-model= "form.picMatObj"></single-upload>
                </el-card>
              </el-timeline-item>
            </el-timeline>
          </el-main>
          <el-footer class="aiFooter">
            <!--          选择单张或者多张-->
            <div class="bar-foot">
              <el-select v-model="form.picNum"
                         ref="selectName"
                         clearable
                         @change= "changeNum"
                         placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.dictValue"
                  :label="item.dictLabel"
                  :value="item.dictValue">
                </el-option>
              </el-select>
              <el-button type="primary">点击生成</el-button>
            </div>

          </el-footer>
        </el-container>
      </div>
      <div v-show=" activeIndexCard == '2'">
<!--        表格-->
        <el-table
          :data="historyTableData"
          style="width: 100%">
          <el-table-column
            prop="createTime"
            label="日期"
            width="180">
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            width="180">
          </el-table-column>
          <el-table-column
            width="120"
            label="原图">
            <template slot-scope="scope">
              <image-preview :src="scope.row.realUrl"  :width="100"></image-preview>
            </template>
          </el-table-column>
          <el-table-column
            width="120"
            label="物料图">
            <template slot-scope="scope">
              <image-preview :src="scope.row.matUrl"  :width="100"></image-preview>
            </template>
          </el-table-column>
          <el-table-column
            prop="mkpic"
            label="合成图">
          </el-table-column>
        </el-table>
        <pagination
          v-show="historyTotal>0"
          :total="historyTotal"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="queryHistList"
        />
      </div>
      <div v-show=" activeIndexCard == '3'">
<!--        剩余积分-->
        <label class="score_tag" >当前剩余积分: <span class="score_tag" style="color: red">{{score}}</span></label>
<!--        积分充值记录详情-->
        <el-table
          :data="scoreList"
          style="width: 100%">
          <el-table-column
            prop="dateTime"
            label="日期"
            width="180">
          </el-table-column>
          <el-table-column
            label="积分"
            width="180">
            <template slot-scope="scope">
                <span v-if="scope.row.addFlag == '1'" class="red_font"> {{"+"+scope.row.score}}</span>
                <span v-if="scope.row.addFlag == '0'" class="green_font">{{"-"+scope.row.score}}</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="note"
            label="备注">
          </el-table-column>
        </el-table>
      </div>
    </el-card>
  </div>
</template>

<script>
import PanelGroup from "../dashboard/PanelGroup";
import { getToken } from "../../utils/auth";
import { listHistory } from "../../api/system/history"
import { listScore, queryScore } from "../../api/system/score"

export default {
      name: "AIIndex",
      components: {PanelGroup, },
      data() {
        return {
          activeIndex: '1',
          activeIndex2: '1',
          activeIndexCard: '1',
          disabled: false,
          dialogVisible: false,
          dialogImageUrl: '', // 展示图片
          historyTotal: 0 ,
          value:[],
          limit: 1,
          headers: {
            Authorization: "Bearer " + getToken(),
          },
          options: [], //数据字典api
          //上传流程列表图
          activities: [{
            content: '上传原图',
            timestamp: '2018-04-12 20:46',
            color: '#0bbd87'
          }, {
            content: '物料图片',
            timestamp: '2018-04-03 20:46',
            color: '#0bbd87'
          }, {
            content: '图片生成',
            timestamp: '2018-04-03 20:46',
            size: 'large'
          }],
          form:{ //提交表单
            userId:'',  //用户id
            bathId:'',  //批次号
            picNum: '1', //图片数量
            picReal: {},  // 原图图片
            picMateriel:'', // 物料图片
            mkPics:[],  //返回图集
            picRealObj:'',
            picMatObj:''
          },
         // tag2 历史记录
          historyTableData:[
          ],
          //tag3 积分页面
          score:'99',
          scoreList:[],
          queryParams:{ //查询参数
            pageNum: 1,
            pageSize: 10,
            createUser:''
          },
          queryScoreParam:{
            pageNum: 1,
            pageSize: 30,
            userId:''
          },
          userScore:{
            userId:"",
          }
        };
      },
      created() {
        this.getDicNum();
      },
      methods: {
        handleSelect(key, keyPath){
          //激活当前页面操作
          console.log(key, keyPath);
          //进行赋值操作
          this.activeIndexCard = key;
          debugger;
          if (key == '2'){
            this.queryHistList();
          }
          if (key == '3'){
            this.queryListScore();
            this.queryPersonScore();
          }
        },
        changeNum(e){
          //键值输出打印
          //选择张数
          this.form.picNum = e ;
          console.log('picNum', this.form)
        },
        //获取张数
        getDicNum(){
          const that = this
          this.getDicts("dic_num").then(res =>{
            debugger;
            that.options = res.data
            console.log("options",that.options)
            }
          )
        },
        queryHistList(){ //历史记录查询
          let user = this.$store.state.user
          console.log("user",user)
          this.queryParams.createUser = user.id;
          listHistory(this.queryParams).then(res =>{
            this.historyTableData = res.rows
          })
        },
        queryListScore(){
          listScore(this.queryScoreParam).then(res=>{
            console.log("res",res);
            this.scoreList = res.rows
          })
        },
        queryPersonScore(){
          queryScore(this.userScore).then(res =>{
            this.score = res;
            // console.log("queryPersonScore",res)
          })
        },
        // 文件上传中处理
        handleFileUploadProgress(event, file, fileList) {
          this.upload.isUploading = true;
        },
        // 文件上传成功处理
        handleFileSuccess(response, file, fileList) {
          this.upload.isUploading = false;
          this.form.filePath = response.url;
          this.msgSuccess(response.msg);
        }
      }
 };
</script>

<style scoped>
  .el-menu--horizontal > .el-menu-item{
    float: right;
  }
  .aiMain{
    height: 80vh ;
  }
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
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  .aiFooter{
    width: 100%;
    height: 80vh ;
  }
  .bar-foot{
    width: 50%;
    height: 80vh;
    margin: auto;
  }
  .score_tag{
   float: right;
  }
  .red_font{
    color: red;
  }
  .green_font{
    color: green;
  }
</style>
