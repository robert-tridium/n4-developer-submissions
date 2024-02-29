/** @jsx spandrel.jsx */
/* eslint-env browser */
define([
	"bajaux/spandrel",
	'bajaux/mixin/subscriberMixIn',
	"nmodule/userServiceView/rc/UserCardWidget",
	"css!nmodule/userServiceView/rc/UserServiceView"
], function(
	spandrel,
	subscriberMixIn,
	UserCardWidget,
) {
	"use strict";

	return class UserServiceView extends spandrel((userService) => {
		const users = userService.getSlots().properties().is("baja:User").toValueArray();
		return (
			<div class="user-service-view">
				<div class="user-grid">
					{ users.map((user, index) => (
						<UserCardWidget
							value={user}
							key={index}
							onClick={() => niagara.env.hyperlink(user.getNavOrd())}
						/>
					))}
				</div>
			</div>
		);
	}) {
		constructor(params) {
			super({ params });

			subscriberMixIn(this);
			this.getSubscriber().attach({
				added: (property, _cx) => property.getType().is("baja:User") && this.rerender(),
				removed: (property, _cx) => property.getType().is("baja:User") && this.rerender(),
			});
		}
	}
});