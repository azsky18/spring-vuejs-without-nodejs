<template>
<div>
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" v-model="article.title">
				<p class="validation-error">{{validationError.title}}</p>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea v-model="article.content"></textarea>
				<p class="validation-error">{{validationError.content}}</p>
			</td>
		</tr>
	</table>
	<div class="btns">
		<router-link to="/articles">취소</router-link>
		<a href="javascript:void(0);" @click="save">저장</a>
	</div>
</div>
</template>

<script>
module.exports = {
	props: ['id'],
	data: function() {
		return {
			article: {}
		}
	},
	mounted: function() {
		this.fetchArticle();
	},
	methods: {
		fetchArticle: function() {
			if (this.id === 'new') {
				return false;
			}
		
			this.$http.get('/api/articles/' + this.id).then(
				function(response) {
					this.$data.article = response.data;
				},
				function(error) {
					this.handleError(error);
				}
			)
		},
		save: function() {
			this.$http.post('/api/article', this.$data.article).then(
				function(response) {
					alert('성공적으로 저장되었습니다.');
					router.push('/articles');
				},
				function(error) {
					this.handleError(error);
				}
			)
		}
	}
}
</script>

<style>
table {
	margin-top: 100px;
}
</style>