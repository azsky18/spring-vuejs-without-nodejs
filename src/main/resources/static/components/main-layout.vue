<template>
<div>
<header>
	<h3><router-link to="/">Test-Project</router-link></h3>
	<p>hi this is test header</p>
</header>
<nav class="global-nav">
	<ul>
		<li>
			<router-link to="/articles">Articles</router-link>
		</li>
		<li class="has-sub-item">
			<router-link to="/users">Users</router-link>
			<ul>
				<li>
					<router-link to="/users/1">Go to User 1</router-link>
				</li>
				<li>
					<router-link to="/users/2">Go to User 2</router-link>
				</li>
			</ul>
		</li>
	</ul>
</nav>
<main>
	<router-view></router-view>
</main>
<footer>
	Copyright ⓒ 2020 Test-Project
</footer>
</div>
</template>

<script>
module.exports = {
    data: function() {
        return {
        }
    }
}
</script>

<style>
header {
	position: fixed;
	top: 0;
	width: 100%;
	height: 40px;
    padding: 5px 10px;
	background: #000;
	color: #fff;
	z-index: 1;
}
header h3 {
	display: inline;
}
header p {
	display: inline;
}
.global-nav {
	margin-top: 40px;
	height: 30px;
}
.global-nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	white-space: nowrap;
}
.global-nav ul li {
	display: inline;
	position: relative;
	float: left;
	padding: 0 10px;
}
.global-nav ul li a {
    text-decoration: none;
}
.global-nav ul li.has-sub-item::after {
	content: '▼';
}
.global-nav ul li ul {
	display: none;
	background: #fff;
	position: absolute;
	border: solid 1px #eee;
	overflow: hidden;
	padding: 5px 0;
}
.global-nav ul li:hover ul {
	display: block;
}
.global-nav ul li ul li {
	display: block;
	float: none;
	padding: 5px 10px;
}
main {
	min-height: calc(100vh - 110px);
    margin: 0 auto;
    width: 800px;
}
footer {
	background: #000;
	color: #fff;
	height: 40px;
	padding: 5px 10px;
}
</style>