<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listBygroupid" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <Material class="material-area" ref="materialArea"></Material>
    </el-main>
  </el-container>

</template>

<script>
import SideMenu from './SideMenu'
import Material from "./Material";
export default {
  name: "materials",
  components: {Material, SideMenu},
  methods: {
    listBygroupid () {
      var _this = this
      var groupid = this.$refs.sideMenu.groupid
      var url = 'categories/' + groupid + '/books'
      this.$axios.get(url).then(resp => {
        if (resp && resp.status === 200) {
          _this.$refs.materialArea.books = resp.data
        }
      })
    }
  }

}
</script>

<style scoped>
.material-area {

  margin-left: auto;
  margin-right: auto;
}
</style>
