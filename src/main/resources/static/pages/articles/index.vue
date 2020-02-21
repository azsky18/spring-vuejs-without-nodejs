<template>
<div>
	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<tr v-for="article in articles.content">
			<td>{{article.id}}</td>
			<td><router-link :to="'/articles/' + article.id">{{article.title}}</router-link></td>
			<td>{{article.modifiedAt | formatDateTime('YYYY-MM-DD HH:mm:ss')}}</td>
		</tr>
	</table>
	<pagination :pageable="articles" @select="fetchArticles"></pagination>
	<div class="btns">
		<router-link to="/articles/new">글쓰기</router-link>
	</div>
</div>
</template>

<script>
module.exports = {
	data: function() {
		return {
			articles: {}
		}
	},
	mounted: function() {
		this.fetchArticles(0);
	},
	methods: {
		fetchArticles: function(page) {
			this.$http.get('/api/articles', {
				params: {
					size: 5,
					page: page
				}
			}).then(
				function(response) {
					this.articles = response.data;
				},
				function(error) {
					alert('fetch articles failed\n' + error.body.message);
				}
			)
		}
	},
	components: {
		pagination: httpVueLoader('/components/pagination.vue')
	}
}
</script>

<style scoped>
table {
	margin-top: 100px;
}
</style>