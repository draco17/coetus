<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="talk.edit" default="Edit Talk" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="list" action="list"><g:message code="talk.list" default="Talk List" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="talk.new" default="New Talk" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="talk.edit" default="Edit Talk" /></h1>
            <g:render template="../util/showErrors" model="['bean':talk]" />
            <g:form method="post" >
                <input type="hidden" name="id" value="${talk?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="event"><g:message code="talk.event" default="Event" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'event','errors')}">
                                    <g:select optionKey="id" from="${Event.list()}" name="event.id" value="${talk?.event?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title"><g:message code="talk.title" default="Title" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'title','errors')}">
                                    <input type="text" maxlength="200" id="title" name="title" value="${fieldValue(bean:talk,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="summary"><g:message code="talk.summary" default="Summary" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'summary','errors')}">
                                    <textarea rows="5" cols="40" name="summary">${fieldValue(bean:talk, field:'summary')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="startDate"><g:message code="talk.startDate" default="Start Date" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'startDate','errors')}">
                                    <g:datePicker name="startDate" value="${talk?.startDate}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="endDate"><g:message code="talk.endDate" default="End Date" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'endDate','errors')}">
                                    <g:datePicker name="endDate" value="${talk?.endDate}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="location"><g:message code="talk.location" default="Location" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'location','errors')}">
                                    <input type="text" maxlength="100" id="location" name="location" value="${fieldValue(bean:talk,field:'location')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="necessaryRegistry"><g:message code="talk.necessaryRegistry" default="Necessary Registry" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'necessaryRegistry','errors')}">
                                    <g:checkBox name="necessaryRegistry" value="${talk?.necessaryRegistry}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="capacity"><g:message code="talk.capacity" default="Capacity" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'capacity','errors')}">
                                    <input type="text" id="capacity" name="capacity" value="${fieldValue(bean:talk,field:'capacity')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="displayCapacity"><g:message code="talk.displayCapacity" default="Display Capacity" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'displayCapacity','errors')}">
                                    <g:checkBox name="displayCapacity" value="${talk?.displayCapacity}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="showStatus"><g:message code="talk.showStatus" default="Show Status" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'showStatus','errors')}">
                                    <g:checkBox name="showStatus" value="${talk?.showStatus}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="speakers"><g:message code="talk.speakers" default="Speakers" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'speakers','errors')}">
                                    
<ul>
<g:each var="s" in="${talk?.speakers?}">
    <li><g:link controller="person" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="person" params="['talk.id':talk?.id]" action="create">Add Person</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status"><g:message code="talk.status" default="Status" />:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:talk,field:'status','errors')}">
                                    <g:select  from="${Status?.values()}" value="${talk?.status}" name="status" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="Update" value="${message(code:'update', 'default':'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('${message(code:'delete.confirm', 'default':'Are you sure?')}');" action="Delete" value="${message(code:'delete', 'default':'Delete')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
