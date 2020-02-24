<template>
<div class="pagination">
	<a href="javascript:void(0);" @click="select(current - 1)">{{prevText}}</a>
	<a href="javascript:void(0);" @click="select(page)" v-for="page in pages" :class="[current === page ? 'active': '']">{{page}}</a>
	<a href="javascript:void(0);" @click="select(current + 1)">{{nextText}}</a>
</div>
</template>

<script>
module.exports = {
	props: {
		pageable: {
			type: Object,
			required: true
		},
		paginationSize: {
			type: Number,
			default: 5
		},
		baseOn: {
			type: Number,
			default: 0
		},
		prevText: {
			type: String,
			default: '<'
		},
		nextText: {
			type: String,
			default: '>'
		}
	},
	data: function() {
		return {
			current: 1
		}
	},
	computed: {
		pages: function() {
			var totalPages = this.pageable.totalPages;
			var current = this.pageable.number + 1;
			var half = parseInt(Math.min(this.paginationSize, totalPages) / 2);
			var end = Math.min(totalPages, current + half);
			var start = Math.max(end - this.paginationSize, 1);
			var length = Math.min(start + this.paginationSize - 1, totalPages);

			var pages = [];
			for (var i = start; i <= length; i++) {
			    pages.push(i);
			}
			
			if (pages.length <= 0) {
				pages = [1];
			}
			
			return pages;
		}
	},
	methods: {
		select: function(page) {
			this.current = Math.max(1, Math.min(page, this.pageable.totalPages));
			this.$emit('select', this.baseOn == 0 ? this.current - 1 : this.current);
		}
	}
}
</script>

<style>
.pagination {
	padding: 20px;
	text-align: center;
}
.pagination a {
    padding: 5px 10px;
}
.pagination .active {
	background-color: #000;
	color: #fff;
}
</style>