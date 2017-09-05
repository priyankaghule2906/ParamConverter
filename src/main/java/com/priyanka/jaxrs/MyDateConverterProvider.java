package com.priyanka.jaxrs;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		// TODO Auto-generated method stub

		if (rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					// TODO Auto-generated method stub

					System.out.println("Passed in value " + value);
					MyDate date = new MyDate();
					Date d = new Date();
					Locale[] locale = Locale.getAvailableLocales();
					for (Locale loc : locale) {
						DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, 0, (Locale) loc);
						String formattedDate = df.format(d);
						if (loc.getDisplayCountry().equalsIgnoreCase(value)) {
							date.setCountry(loc.getDisplayCountry());
							date.setLanguage(loc.getDisplayLanguage());
							date.setPlainDate(new Date());
							date.setFormattedDate(formattedDate);
						} else {
							date.setPlainDate(new Date());
						}

					}
					return rawType.cast(date);
				}

				@Override
				public String toString(T myBean) {
					// TODO Auto-generated method stub
					if (myBean == null) {
						return null;
					}
					return myBean.toString();
				}
			};

		}
		return null;
	}
}
