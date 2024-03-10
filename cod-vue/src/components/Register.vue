<template>
  <body id="paper">
  <el-form :model="loginForm"  :rules="rules"  class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">用户注册</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item prop="password2">
      <el-input type="password" v-model="loginForm.password2"
                auto-complete="off" placeholder="确认密码"></el-input>
    </el-form-item>
    <el-form-item prop="number">
      <el-input type="text" v-model="loginForm.number"
                auto-complete="off" placeholder="学号"></el-input>
    </el-form-item>
    <el-form-item  v-model="loginForm.group_id" prop="group_id" >
      <el-select v-model="loginForm.group_id" placeholder="请选择组别">
        <el-option label="视觉" value="1"></el-option>
        <el-option label="电控" value="2"></el-option>
        <el-option label="机械" value="3"></el-option>
        <el-option label="硬件" value="4"></el-option>
        <el-option label="运营" value="5"></el-option>
        <el-option label="其他" value="6"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="register">注册</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>
<script>
export default{
  data () {
    return {
      rules:{
        username: [{required: true, message: '请输入你的名字', trigger: 'blur'}],
        password: [{required: true, message: '请给自己想一个安全的密码', trigger: 'blur'}],
        password2: [{required: true,message:'再输入一次哦', trigger: 'blur'},{
          validator:(rules,value,callback)=>{
            if(value===''){
              callback(new Error('请再次输入密码'))
            }else if(value!==this.loginForm.password){
              callback(new Error('两次输入密码不一致'))
            }else{
              callback( )
            }
          },
          trigger:'blur'
        }],
        number:[{required: true, message: '学号是判断你身份的唯一标准', trigger: 'blur'}],
        group_id:[{required: true, message: '请选择组别', trigger: 'blur'}]
      },
      checked: true,
      loginForm: {
        username: '',
        password: '',
        password2:'',
        number:'',
        group_id:''
      },
      loading: false
    }
  },
  methods: {
    register () {
      if(this.loginForm.username!==''&&this.loginForm.password!==''&&this.loginForm.password2===this.loginForm.password&&this.loginForm.number!==''&&this.loginForm.group_id!=='')
      {
        const _this = this;
      this.$axios
        .post('/register', {
          username: this.loginForm.username,
          password: this.loginForm.password,
          number: this.loginForm.number,
          group_id:this.loginForm.group_id
        })
        .then(resp => {
          if (resp.data.code === 200) {
            this.$alert('注册成功', '提示', {
              confirmButtonText: '确定'
            })
            _this.$router.replace('/login')
          } else {
            this.$alert(resp.data.message, '提示', {
              confirmButtonText: '确定'
            })
          }
        })
        .catch(failResponse => {})
    }
      else {
        this.$message({
          message: '看看是不是忘了点啥- -！',
          type: 'warning'
        })
      }
    }
  }
}
</script>
<style>
#paper {
  background: url("../assets/bg/cod1.jpg") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body{
  margin: -5px 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>

