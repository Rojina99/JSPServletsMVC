package businessservice;

import java.util.HashMap;

import dto.UserDetails;

public class LoginService {
	
	HashMap<String , String> users = new HashMap<>();
	
	public LoginService()
	{
		users.put("roji", "Rojina Panta");
		users.put("rupi", "Rupak Panta");
		users.put("dibya", "Dibya Kanta Panta");
		users.put("kamala", "Kamala Panta (Shiwakoti)");
	}

	
	public boolean authenciate(String userId , String password)
	{
		if(userId!=null && !userId.trim().isEmpty() && password!=null && !password.trim().isEmpty())
			{
				return true;
			}
		else
		{		
		return false;
		}
	}
	
	
	public UserDetails getUserDetails(String userId)
	{
		UserDetails ud = new UserDetails();
		ud.setUserName(users.get(userId));
		ud.setUserId(userId);
		return ud;
	}
}
