package com.abdul.springsecurity.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	private static final Logger logger = LogManager.getLogger(CommonUtil.class);
	private String strTimeStamp = "timestamp";
	private String strMessage = "message";
	public Map<String, Object> getInternalServerError() {

		Map<String, Object> json = new LinkedHashMap<>();

		try {
			json.put(strTimeStamp, new Date());
			json.put(strMessage, "failure");
		} catch (Exception e) {
			logger.error("", e);
		}
		return json;
	}

	public Map<String, Object> getInternalServerError(String message) {

		Map<String, Object> json = new LinkedHashMap<>();

		try {
			json.put(strTimeStamp, new Date());
			json.put(strMessage, message);
		} catch (Exception e) {
			logger.error("", e);
		}
		return json;
	}

	public Map<String, Object> getSuccessMessage() {

		Map<String, Object> json = new LinkedHashMap<>();

		try {
			json.put(strTimeStamp, getFormatedDateByDate(new Date(), null));
			json.put(strMessage, "success");
		} catch (Exception e) {
			logger.error("", e);
		}
		return json;
	}

	public Map<String, Object> getSuccessMessage(String message) {

		Map<String, Object> json = new LinkedHashMap<>();

		try {
			json.put(strTimeStamp, getFormatedDateByDate(new Date(), null));
			json.put(strMessage, message);
		} catch (Exception e) {
			logger.error("", e);
		}
		return json;
	}
	
	public static Date getFormatedDateByDate(Date date, String format) {

		Date newDate = null;

		try {
			if (null == format) {
				format = CoreConstants.DEFAULT_DATE_TIME_FORMAT;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			newDate = sdf.parse(sdf.format(date));
		} catch (Exception e) {
			logger.error("", e);
		}
		return newDate;
	}
}
