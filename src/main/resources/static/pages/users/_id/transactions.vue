<template>
<div>
	<span>Hello I'm User {{id}}'s Transactions!</span>
</div>
</template>

<script>
module.exports = {
	props: ['id']
}
</script>

<style scoped>
div {
	padding: 100px;
}
</style>