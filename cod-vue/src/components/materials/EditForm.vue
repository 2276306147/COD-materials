<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog
      title="添加/修改物资"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="名称" :label-width="formLabelWidth" prop="name">
          <el-input v-model="form.name" autocomplete="off" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label="编号" :label-width="formLabelWidth" prop="productId">
          <el-input v-model="form.productId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="状态" :label-width="formLabelWidth" prop="state">
          <el-input v-model="form.state" autocomplete="off" placeholder="0借出\1未借出"></el-input>
        </el-form-item>
        <el-form-item label="使用人" :label-width="formLabelWidth" prop="bind">
          <el-input v-model="form.bind" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="封面" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.cover" autocomplete="off" placeholder="图片 URL"></el-input>
          <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
        </el-form-item>
        <el-form-item label="位置信息" :label-width="formLabelWidth" prop="location">
          <el-input type="textarea" v-model="form.location" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分类" :label-width="formLabelWidth" prop="groupid">
          <el-select v-model="form.groupid" placeholder="请选择分类">
            <el-option label="视觉" value="1"></el-option>
            <el-option label="电控" value="2"></el-option>
            <el-option label="机械" value="3"></el-option>
            <el-option label="硬件" value="4"></el-option>
            <el-option label="运营" value="5"></el-option>
            <el-option label="其他" value="6"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import ImgUpload from './ImgUpload';
export default {

  name: 'EditForm',
  components: {ImgUpload},
  data () {
    return {
      dialogFormVisible: false,
      form: {
        id: '',
        name: '',
        productId: '',
        state: '',
        bind: '',
        cover: '',
        location: '',
        groupid: ''
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    clear () {
      this.form = {
        id: '',
        name: '',
        productId: '',
        state: '',
        bind: '',
        cover: '',
        location: '',
        groupid: ''
      }
    },
    onSubmit () {
      this.$axios
        .post('/materials', {
          id: this.form.id,
          cover: this.form.cover,
          name: this.form.name,
          productId: this.form.productId,
          state: this.form.state,
          bind: this.form.bind,
          location: this.form.location,
          groupid: this.form.groupid
        }).then(resp => {
        if (resp && resp.status === 200) {
          this.dialogFormVisible = false
          this.$emit('onSubmit')
        }
      })
    },
    uploadImg () {
      this.form.cover = this.$refs.imgUpload.url
    }

  }
}
</script>

<style scoped>
.el-icon-circle-plus-outline {
  margin: 50px 0 0 20px;
  font-size: 100px;
  float: left;
  cursor: pointer;
}
</style>


