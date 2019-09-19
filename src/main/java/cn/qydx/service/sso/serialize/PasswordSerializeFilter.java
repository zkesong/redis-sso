package cn.qydx.service.sso.serialize;

import com.alibaba.fastjson.serializer.ValueFilter;

public class PasswordSerializeFilter implements ValueFilter{

	@Override
	public Object process(Object object, String name, Object value) {
		if("passwd".equals(name)) {
			return "******";
		}
		return value;
	}
}
