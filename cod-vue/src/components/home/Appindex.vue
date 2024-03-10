<template>
 <div>
   Hello {{username}}!

    广告位招商(●ˇ∀ˇ●)
 </div>
</template>

<script>
export default {
  name: "Appindex",
  data(){
    return{
      username:JSON.parse(localStorage.getItem("user")).username
    }
  }
}
</script>

<style scoped>

</style>
