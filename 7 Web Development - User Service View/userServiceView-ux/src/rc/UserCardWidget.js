/** @jsx spandrel.jsx */
/* eslint-env browser */
define([
	"baja!",
	"bajaux/spandrel",
	'bajaux/mixin/subscriberMixIn',
	"css!nmodule/userServiceView/rc/UserCard"
], function(
	baja,
	spandrel,
	subscriberMixIn,
) {
	"use strict";

	return class UserCardWidget extends spandrel((user) => {

		function extractInitials(name) {
			return name.split(" ")
				.map(token => token.length > 0 ? token[0] : "")
				.join("")
				.toUpperCase();
		}

		const roles = user.getRoles().split(",")
			.filter(role => role !== "")
			.map(baja.SlotPath.unescape);
		const username = baja.SlotPath.unescape(user.getName().trim());
		const fullname = user.getFullName().trim();
		const initials = extractInitials(fullname) || extractInitials(username);
		const cardClasses = `user-card ${user.getEnabled() ? "enabled" : "disabled"}`;

		return (
			<div className={cardClasses}>
				<p class="user-initials">{ initials }</p>
				<div class="user-name">
					<p class="primary-name">{ fullname || username }</p>
					{!!fullname &&
						<p class="secondary-name">{ username }</p>
					}
				</div>
				<p class="user-roles">
					{roles.map((role, index) => (
						<span class="role-badge" key={index}>{role}</span>
					))}
				</p>
			</div>
		);
	}) {
		constructor(params) {
			super({ params });

			subscriberMixIn(this);
			this.getSubscriber().attach("changed", (property, _ctx) => {
				const isRenderedProperty = ["fullName", "name", "enabled", "roles"].includes(property.getName());
				if(isRenderedProperty) this.rerender();
			});
		}
	}
});