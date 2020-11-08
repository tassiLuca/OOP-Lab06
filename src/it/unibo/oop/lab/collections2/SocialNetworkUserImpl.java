package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {
	
	private final Map<String, Set<U>> friends = new HashMap<>();	// inference of type-variables

	/**
     * Builds a new participating in a social network (age won't be set)
     * 
     * @param name
     * 			the user first name
     * @param surname
     * 			the user last name
     * @param user
     * 			alias of the user, i.e. the way a user is identified on an 
     * 			application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
    	this(name, surname, user, -1);
    }
    
	/**
     * Builds a new participating in a social network.
     * 
     * @param name
     *            the user first name
     * @param surname
     *            the user last name
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

	public boolean addFollowedUser(final String group, final U user) {
		Set<U> groupFriends = this.friends.get(group);
		if (groupFriends == null) {
			groupFriends = new HashSet<>();
			this.friends.put(group, groupFriends);
		}
		return groupFriends.add(user);
	}

	public List<U> getFollowedUsers() {
		/* 
		 * Pre-populate a Set in order to prevent duplicates. 
		 */
		final Set<U> followedUsers = new HashSet<>();
		for (final Set<U> group : friends.values()) {
			followedUsers.addAll(group);
		}
		return new ArrayList<U>(followedUsers);
	}

	/**
	 * [NOTE] If no group with groupName exists yet, this implementation 
	 * must return an empty Collection.
	 */
	public Collection<U> getFollowedUsersInGroup(String groupName) {
		final Collection<U> usersInGroup = this.friends.get(groupName);
		if (usersInGroup != null) {
			return new ArrayList<U>(usersInGroup);
		}
		return Collections.emptyList();
	}

}
