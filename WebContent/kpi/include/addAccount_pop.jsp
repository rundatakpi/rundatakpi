<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<form id='form1' action="">
	<dl class="addAccountList">
		<dd class="clearfix">
	    	<label class="left">宽带账号：</label>
	        <input type="text" name="account" class="left longInput" />
	    </dd>
		<dd class="clearfix">
	    	<label class="left">关联手机号：</label>
	        <textarea name="phone" class="left longTextarea"></textarea>
	    </dd>
		<dd class="clearfix">
	    	<label class="left">关联IMEI：</label>
	        <textarea name="imei" class="left longTextarea"></textarea>
	    </dd>
		<dd class="clearfix">
	    	<label class="left">关联IMSI：</label>
	        <textarea name="imsi" class="left longTextarea"></textarea>
	    </dd>
		<dd class="clearfix">
	    	<label class="left">关联MAC：</label>
	        <textarea name="mac" class="left longTextarea"></textarea>
	    </dd>
	    <dt>注：可输入多个关联号码，使用<span>“,”</span>隔开。如<span>13811223344,13512341234</span></dt>
	</dl>
</form>