/**
 *
 */
package de.hybris.merchandise.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;


/**
 * @author Admin
 *
 */
public class DiscountTextValuePopulator extends SearchResultVariantProductPopulator
{

	@Override
	public void populate(final SearchResultValueData source, final ProductData target)
	{

		super.populate(source, target);
		System.out.println("In discount populator +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		target.setDiscountText(this.<String> getValue(source, "discountText"));

	}
}
