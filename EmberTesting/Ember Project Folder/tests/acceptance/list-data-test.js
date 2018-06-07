import { module, test } from 'qunit';
import { visit, currentURL } from '@ember/test-helpers';
import { setupApplicationTest } from 'ember-qunit';
import {
  click, 
} from '@ember/test-helpers';

module('Acceptance | list data', function(hooks) {
  setupApplicationTest(hooks);

  test('visiting /', async function(assert) {
    await visit('/');

    assert.equal(currentURL(), '/');
  });

  test('Should link to about page.', async function(assert) {
    await visit('/');
    await click(".menu-contact");

    assert.equal(currentURL(), '/about', 'Should navegate to about page.');
  });
});
