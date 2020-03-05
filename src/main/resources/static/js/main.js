requirejs.config({
	baseUrl: '/js',
	paths: {
		'Vue': 'lib/vue',
		'VueRouter': 'lib/vue-router',
		'VueResource': 'lib/vue-resource.min',
		'httpVueLoader': 'lib/http-vue-loader',
		'moment': 'lib/moment-with-locales.min' 
	}
});

requirejs([
		'Vue',
		'VueRouter',
		'VueResource',
		'httpVueLoader',
		'moment'
	],
	function(Vue, VueRouter, VueResource, httpVueLoader) {
		Vue.use(VueRouter);
		Vue.use(VueResource);
	
		Vue.filter('formatDateTime', function(value, format) {
			return moment(value).format(format);
		});
	
		Vue.mixin({
			data:  function () {
				return {
					validationError: {}
				}
		    },
			methods: {
				handleError: function(error) {
					for (var key in this.validationError) {
						Vue.delete(this.validationError, key);
					}
					
					var errors = error.body.errors;
					for (var index in errors) {
						var e = errors[index];
						Vue.set(this.validationError, e.field, e.defaultMessage);
					}
					
					if (Object.keys(this.validationError).length === 0) {
						alert(error.body.message);
					}
					
					return error;
				}
			}
		});
	
		var router = new VueRouter({
			mode: 'history',
			routes: []
		});
	
		var app = new Vue({
			router,
			el: '#app',
			mounted: function() {
				this.fetchRoutes();
			},
			methods: {
				fetchRoutes: function() {
					this.$http.get('/vue-initialize').then(
						function(response) {
							var routes = this.makeRoutes(response.data.vueRouters);
							this.$router.addRoutes(routes);
						},
						function(error) {
							console.error('vue-initialize failed', error);
							alert('vue-initialize failed\n' + error.body.message);
						}
					)
				},
				makeRoutes: function(routes) {
					var routesObject = [];
					
					for (var index in routes) {
						var route = routes[index];
						routesObject.push({
							path: route.path,
							component: httpVueLoader(route.component),
							children: this.makeRoutes(route.children),
							props: true
						});
					}
					
					return routesObject;
				}
			},
			components: {
				'main-layout': httpVueLoader('/components/main-layout.vue')
			}
		});
	}
);