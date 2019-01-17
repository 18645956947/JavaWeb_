package cookieutil;

import javax.servlet.http.Cookie;

/** 
* @author lenovo
* @date 2019��1��17������2:59:29 
* @Description: 
*/
public class CookieUtil {
	public static Cookie findCookie(Cookie[] cookies, String name) {
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		
		return null;
	}
}
 