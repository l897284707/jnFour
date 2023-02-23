<template>
<div>
    <div class="filter-container">
      <!-- <el-input placeholder="项目编码/项目名称" v-model="pagination.queryString" style="width: 200px;" class="filter-item"></el-input>-->
      <!--  <el-button @click="findPage()" class="dalfBut">查询</el-button>-->
      <el-button type="primary" class="butT" @click="handleCreate()">新建</el-button>
    </div>
    <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>
      <el-table-column type="index" align="center" label="序号"></el-table-column>
      <el-table-column prop="dname" label="设备名称" align="center"></el-table-column>
      <el-table-column prop="address" label="设备地址" align="center"></el-table-column>
      <el-table-column prop="max" label="最大值" align="center"></el-table-column>
      <el-table-column prop="min" label="最小值" align="center"></el-table-column>
      <el-table-column prop="tname" label="设备类型" align="center"></el-table-column>
      <el-table-column prop="createtime" label="创建时间" align="center"></el-table-column>
      <el-table-column prop="updatetime" label="修改时间" align="center"></el-table-column>
      <!--
                              <template slot-scope="scope">
                                      <span>{{ scope.row.sex == '0' ? '不限' : scope.row.sex == '1' ? '男' : '女'}}</span>
                                  </template>
                              </el-table-column>
                              <el-table-column prop="age" label="适用年龄" align="center"></el-table-column>
                              <el-table-column prop="remark" label="项目说明" align="center"></el-table-column>-->
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <!--分页插件-->
      <el-pagination
        background
        class="pagiantion"
        @current-change="handleCurrentChange"
        :current-page="pagination.currentPage"
        :page-size="pagination.pageSize"
        layout="total, prev, pager, next, jumper"
        :total="pagination.total">
      </el-pagination>
    </div>
    <!-- 新增标签弹层 -->
    <div class="add-form">
      <!-- //新增页面默认是false不展示 -->
      <el-dialog title="新增设备" :visible.sync="dialogFormVisible">
        <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">
          <!--一行-->
          <el-row>
            <el-col :span="24">
              <el-form-item label="设备名称" prop="dname">
                <el-input v-model="formData.dname"/>
              </el-form-item>
            </el-col>
          </el-row>
          <!--一行-->
          <el-row>
            <el-col :span="24">
              <el-form-item label="设备地址" prop="address">
                <el-input v-model="formData.address"/>
              </el-form-item>
            </el-col>
          </el-row>
          <!--一行-->
          <el-row>
            <el-col :span="12">
              <el-form-item label="最大值" prop="max">
                <el-input v-model="formData.max"/>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="最小值" prop="min">
                <el-input v-model="formData.min"/>
              </el-form-item>
            </el-col>
          </el-row>
          <!--一行-->
          <el-row>
            <el-col :span="24">
                <el-form-item label="选择设备种类" prop="tid">
                  <el-radio v-model="formData.tid" :label="type.tid" v-for="type in types">{{type.tname}}</el-radio>
                </el-form-item>
            </el-col>
          </el-row>


        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="handleAdd()">确定</el-button>
        </div>
      </el-dialog>
    </div>

    <!-- 编辑标签弹层 -->
    <div class="add-form">
      <el-dialog title="编辑设备" :visible.sync="dialogFormVisible4Edit">
        <el-form ref="dataEditForm" :model="formData" :rules="rules" label-position="right" label-width="100px">
          <el-row>
            <el-col :span="24">
              <el-form-item label="设备名称" prop="dname">
                <el-input v-model="formData.dname"/>
              </el-form-item>
            </el-col>
          </el-row>
          <!--一行-->
          <el-row>
            <el-col :span="24">
              <el-form-item label="设备地址" prop="address">
                <el-input v-model="formData.address"/>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
          <el-col :span="12">
              <el-form-item label="最大值" prop="max">
                <el-input v-model="formData.max"/>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
          <el-col :span="12">
              <el-form-item label="最小值" prop="min">
                <el-input v-model="formData.min"/>
              </el-form-item>
            </el-col>
          </el-row>
          <!--一行-->
          <el-row>
            <el-col :span="24">
              <el-form-item label="选择设备种类" prop="tid">
                <el-radio v-model="formData.tid" :label="type.tid" v-for="type in types">{{type.tname}}</el-radio>
              </el-form-item>
            </el-col>
          </el-row>

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible4Edit = false">取消</el-button>
          <el-button type="primary" @click="handleEdit()">确定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "index",
  data(){
    return{
      //分页对象
      pagination: {//分页相关模型数据
        currentPage: 1,//当前页码
        pageSize:10,//每页显示的记录数
        total:0,//总记录数
        queryString:null//查询条件
      },
      dataList: [],//当前页要展示的分页列表数据
      formData: {},//表单数据
      dialogFormVisible: false,//增加表单是否可见
      dialogFormVisible4Edit:false,//编辑表单是否可见
      rules: {//校验规则
        pname: [{ required: true, message: '项目编码为必填项', trigger: 'blur' }],
        starttime: [{ required: true, message: '开始时间为必填项', trigger: 'blur' }],
        endtime: [{ required: true, message: '结束时间为必填项', trigger: 'blur' }]
      },

    }
  },
  //钩子函数，VUE对象初始化完成后自动执行
  created() {
    this.findPage();//VUE对象初始化完成后调用分页查询方法，完成分页查询
  },
  methods: {
    //查询所有种类
    findTypes(){
      this.axios.get("http://localhost:8088/type/findAll").then((res)=>{
        this.types=res.data
      });
    },
    //编辑
    handleEdit() {
      //进行表单校验
      this.$refs['dataEditForm'].validate((valid) => {
        if(valid){
          //表单校验通过，可以提交数据
          console.log(this.formData)
          this.axios.post("http://localhost:8088/device/editDevice",this.formData).then((res) => {
            if(res.data.flag){
              //弹出成功提示信息
              this.$message({
                type:'success',
                message:res.data.message
              });
            }else{
              //执行失败
              this.$message.error(res.data.message);
            }
          }).finally(() => {
            //不管成功还是失败，都调用分页查询方法
            this.findPage();
            //隐藏编辑窗口
            this.dialogFormVisible4Edit = false;
          });
        }else{
          //表单校验不通过
          this.$message.error("表单数据校验失败!");
          return false;
        }
      });
    },
    //添加
    handleAdd () {
      //进行表单校验   validate
      this.$refs['dataAddForm'].validate((valid) => {
        if(valid){
          //表单校验通过，发生ajax请求，将录入的数据提交到后台进行处理
          console.log(this.formData);
          //添加接口：url、application/json,project实体
          this.axios.post("http://localhost:8088/device/addDevice",this.formData).then((res) => {
            //关闭新增窗口
            this.dialogFormVisible = false;
            if(res.data.flag){//执行成功
              //新增成功后，重新调用分页查询方法，查询出最新的数据
              this.findPage();
              //弹出提示信息
              this.$message({
                message:res.data.message,
                type:'success'
              });
            }else{//执行失败
              //弹出提示
              this.$message.error(res.data.message);
            }
          });
        }else{
          //校验不通过
          this.$message.error("数据校验失败，请检查你的输入信息是否正确！");
          return false;
        }
      });
    },
    //分页查询
    findPage() {
      //发送ajax请求，提交分页相关请求参数（页码、每页显示记录数、查询条件）
      var param = {
        currentPage:this.pagination.currentPage,
        pageSize:this.pagination.pageSize,
        queryString: this.pagination.queryString
      };
      //接口url、请求type,请求参数、响应数据
      this.axios.post("http://localhost:8088/device/findPage",param).then((res)=>{
        //解析Controller响应回的数据，为模型数据赋值
        console.log(res.data.total);
        this.pagination.total = res.data.total;
        //给表格要遍历的数据赋值
        this.dataList = res.data.rows;
      });
    },
    // 重置表单
    resetForm() {
      this.formData = {};//重置数据
    },
    // 弹出添加窗口
    handleCreate() {
      this.findTypes()
      //弹出新增窗口
      this.dialogFormVisible = true;
      this.resetForm();
    },
    // 弹出编辑窗口
    handleUpdate(row) {
      //弹出编辑窗口
      this.dialogFormVisible4Edit = true;
      //回显数据，发送ajax请求根据ID查询当前检查项数据
      this.axios.get("http://localhost:8088/device/findById?id=" + row.id).then((res) => {
        if(res.data.flag){
          //进行回显，基于VUE的数据绑定实现
          this.formData = res.data.data;
          console.log(this.formData)
          this.findTypes()
        }else{
          //查询失败，弹出提示
          this.$message.error(res.data.message);
        }
      });
    },
    //切换页码
    handleCurrentChange(currentPage) {
      //设置最新的页码
      this.pagination.currentPage = currentPage;
      //重新调用findPage方法进行分页查询
      this.findPage();
    },
    // 删除
    handleDelete(row) {//row其实是一个json对象，json对象的结构为{"age":"0-100","attention":"无","code":"0011","id":38,"name":"白细胞计数","price":10.0,"remark":"白细胞计数","sex":"0","type":"2"}
      //alert(row.id);
      this.$confirm("你确定要删除当前数据吗？","提示",{//确认框
        type:'warning'
      }).then(()=>{
        //用户点击确定按钮，发送ajax请求，将检查项ID提交到Controller进行处理
        this.axios.get("/device/deleteById?id=" + row.id).then((res) => {
          if(res.data.flag){
            //执行成功
            //弹出成功提示信息
            this.$message({
              type:'success',
              message:res.data.message
            });
            //重新进行分页查询
            this.findPage();
          }else{
            //执行失败
            this.$message.error(res.data.message);
          }
        });
      }).catch(()=>{
        this.$message({
          type:'info',
          message:'操作已取消'
        });
      });
    }
  }

}
</script>

<style scoped>

</style>
