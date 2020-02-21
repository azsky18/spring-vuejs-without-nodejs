<template>
<div class="user-page">
	<h3>Hello I'm User {{id}}!</h3>
	<nav class="user-nav">
		<ul>
			<li>
				<router-link :to="'/users/' + id + '/profile'">PROFILE</router-link>
			</li>
			<li>
				<router-link :to="'/users/' + id + '/transactions'">TRANSACTIONS</router-link>
			</li>
		</ul>
	</nav>
	<section class="user-section">
		<router-view></router-view>
	</section>
</div>
</template>

<script>
module.exports = {
	props: ['id']
}
</script>

<style>
.user-page {
	height: 500px;
}
.user-nav {
	width: 200px;
	float: left;
	background: #eee;
	height: 100%;
	padding: 10px;
}
.user-section {
	height: 100%;
	float: left;
	padding: 10px;
}
</style>