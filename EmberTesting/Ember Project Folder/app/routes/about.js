import Route from '@ember/routing/route';

export default Route.extend({
	store: Ember.inject.service(),
	model() {
		// return 'This is a test website!';
		console.log('aaaa');
		var store = this.get('store');
		var greeting = this.store.findAll('greeting');
		return greeting; //Do we need a comma instead of a ; ?
	}
});

// App.PhotoRoute = Ember.Route.extend({
//   model: function(params) {
//     return this.store.find('greeting');
//   }
// });
