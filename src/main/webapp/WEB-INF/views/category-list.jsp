<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<h3>Category List page</h3>
<a href="${pageContext.request.contextPath}/Admin/Category/create">Add
	Category</a>
	<c:if test="${fn:length(categorylist) gt 0}">
	<table>
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.CategoryId" /></th>
				<th><spring:message code="fieldLabel.CategoryName" /></th>
				<th><spring:message code="caption.edit" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="Category" items="${categorylist}">
				<tr class="listRecord">
					<td>${Category.categoryId}</td>
					<td>${Category.categoryname}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/Admin/Category/edit/${Category.categoryId}.html"><spring:message
								code="caption.edit" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
