<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/desktop/cart" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="storepickup" tagdir="/WEB-INF/tags/desktop/storepickup" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/desktop/action" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<spring:theme code="text.addToCart" var="addToCartText"/>
<c:url value="${product.url}" var="productUrl"/>

<c:set value="${not empty product.potentialPromotions}" var="hasPromotion"/>

<div class="productListItem${hasPromotion ? ' productListItemPromotion' : ''}">
	<ycommerce:testId code="test_searchPage_wholeProduct">
		<a href="${productUrl}" title="${product.name}" class="productMainLink">
			<div class="thumb">
				<product:productPrimaryImage product="${product}" format="product"/>
				<c:if test="${not empty product.potentialPromotions and not empty product.potentialPromotions[0].productBanner}">
					<img class="promo" src="${product.potentialPromotions[0].productBanner.url}" alt="${product.potentialPromotions[0].description}" title="${product.potentialPromotions[0].description}"/>
				</c:if>
			</div>

			<%-- <ycommerce:testId code="searchPage_price_label_${product.code}">
				<div class="price"><product:productListerItemPrice product="${product}" /></div>
		
			</ycommerce:testId> --%>
			
			<ycommerce:testId code="searchPage_price_label_${product.code}">
				<div class="price"><product:productListerItemPrice product="${product}"/></div>
			</ycommerce:testId>
			<ycommerce:testId code="searchPage_productName_link_${product.code}">
				<div class="head">${product.name}</div>
				  <div><h3 style="color: #1a618b; height: 25px; width: 100vh;">&nbsp &nbsp ${product.discountText}</h3></div>
			</ycommerce:testId>
			<c:if test="${not empty product.averageRating}">
				<product:productStars rating="${product.averageRating}"/>
			</c:if>
			<c:if test="${not empty product.summary}">
				<div class="details">${product.summary}</div>
			</c:if>
			<product:productListerClassifications product="${product}"/>

			<c:set var="product" value="${product}" scope="request"/>
			<c:set var="addToCartText" value="${addToCartText}" scope="request"/>
			<c:set var="addToCartUrl" value="${addToCartUrl}" scope="request"/>
			
			<c:if test="${not product.multidimensional}">
				<div id="actions-container-for-${component.uid}" class="listAddPickupContainer clearfix">
					<action:actions element="div" parentComponent="${component}"/>
				</div>
			</c:if>
		
            </a>
            
                <c:choose>
                    <%-- Verify if products is a multidimensional product --%>
                    <c:when test="${product.multidimensional}">
						<div class="cart clearfix">
	                        <c:url var="backToProductUrl" value="${productUrl}" />
	                        <c:url var="productOrderFormUrl" value="${product.url}/orderForm"/>
	
	                        <a href="${backToProductUrl}" class="button right" ><spring:theme code="product.view.details" /></a>
	
	
	                        <sec:authorize ifAnyGranted="ROLE_CUSTOMERGROUP">
	                            <a href="${productOrderFormUrl}"  class="button right"><spring:theme code="order.form" /></a>
	
	                        </sec:authorize>
						</div>
                    </c:when>
                    <c:otherwise>
                        <ycommerce:testId code="searchPage_addToCart_button_${product.code}">
                        	
				            <c:set var="buttonType">submit</c:set>
				            <c:choose>
				                <c:when test="${product.stock.stockLevelStatus.code eq 'outOfStock' }">
				                    <c:set var="buttonType">button</c:set>
				                 
				                    <spring:theme code="text.addToCart.outOfStock" var="addToCartText"/>
				                </c:when>
				            </c:choose>
			            </ycommerce:testId>
                    </c:otherwise>
                </c:choose>
        </ycommerce:testId>
</div>

