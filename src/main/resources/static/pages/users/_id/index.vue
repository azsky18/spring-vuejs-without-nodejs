<template>
</template>

<script>
module.exports = {
	props: ['id'],
	mounted:function() {
		router.push('/users/' + this.id + '/profile');
	}
}
</script>