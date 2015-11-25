<#import '/spring.ftl' as s/>

<#macro url path>
	<@s.url path/>
</#macro>

<#macro image path>
	http://www.yanmushi.com/${path}
</#macro>