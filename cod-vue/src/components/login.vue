<template>
  <body id = "poster">
  <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading = "loading">
    <h3 class="login_title">COD物资管理系统</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: rgba(19,8,6,0.96);border: none" v-on:click="login">登录</el-button>
      <router-link to="register"><el-button type="primary" style="width: 40%;background: #505458;border: none">注册</el-button></router-link>
    </el-form-item>
  </el-form>
  </body>
</template>


<script>
export default {

  data () {
    return {
      rules:{
        username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
      },
      checked:true,
      loginForm: {
        username: '',
        password: ''
      },
      loading: false
    }
  },
  methods: {
    login () {


      if(this.loginForm.username !==''&& this.loginForm.password !=='') {

        var _this = this
        console.log(this.$store.state)
        this.$axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(successResponse => {
            console.log(successResponse.data.code)
            if (successResponse.data.code === 200) {
              // var data = this.loginForm
              _this.$store.commit('login', _this.loginForm)
              const path = this.$route.query.redirect;
              this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
            }
            else{

              this.$alert(successResponse.data.message, '提示', {
                confirmButtonText: '确定'
              })
            }
          })
          .catch(failResponse => {

          })

      } else {  //否则给出提示信息
        this.$message({
          message: '请输入账号和密码！',
          type: 'warning'
        })
        this.isEmpty = true
      }


    }
  }
}

</script>

<style>
#poster {
  background: url("../assets/bg/cod1.jpg") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body{
  margin: 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: transparent;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #303336;
}


</style>
