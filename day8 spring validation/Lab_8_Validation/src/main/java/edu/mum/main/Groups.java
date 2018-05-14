package edu.mum.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Authority;
import edu.mum.domain.Group;
import edu.mum.service.GroupService;
import edu.mum.service.UserCredentialsService;

@Component
public class Groups {

	@Autowired
	GroupService groupService;

	@Autowired
	UserCredentialsService userCredentialsService;

	public void addGroups() {
		Authority authority = new Authority();

		Group groupAdmin = new Group();
		groupAdmin.setGroup_name("ADMIN");
		authority = new Authority();
		authority.setAuthority("ROLE_ADMIN");
		groupAdmin.getAuthority().add(authority);
		

		// Create SUPERVISOR Group
		Group groupSuper = new Group();
		groupSuper.setGroup_name("SUPERVISOR");
		authority = new Authority();
		authority.setAuthority("ROLE_SUPER");
		groupSuper.getAuthority().add(authority);

		// Add LIST to both groups
		authority = new Authority();
		authority.setAuthority("list");
		groupAdmin.getAuthority().add(authority);
		groupSuper.getAuthority().add(authority);

		// Add READ to both Groups
		authority = new Authority();
		authority.setAuthority("read");
		groupAdmin.getAuthority().add(authority);
		groupSuper.getAuthority().add(authority);

		// Add Update to Super only
		authority = new Authority();
		authority.setAuthority("update");
		groupSuper.getAuthority().add(authority);

		// Add Create to Admin only
		authority = new Authority();
		authority.setAuthority("create");
		groupAdmin.getAuthority().add(authority);

		// Add users to groups
		// TODO wrong???
		groupAdmin.getUserCredentials().add(userCredentialsService.findByUserName("Sean"));
		groupSuper.getUserCredentials().add(userCredentialsService.findByUserName("Paul"));
		// userCredentialsService.findByUserName("Sean");

		// Save groups
		groupService.save(groupAdmin);
		groupService.update(groupSuper);

	}
}
