/**
 *
 */
package de.hybris.merchandise.search.providers;


import de.hybris.platform.commerceservices.search.solrfacetsearch.provider.impl.ProductReviewAverageRatingValueProvider;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;


public class FilterBasedOnEnumProvider extends ProductReviewAverageRatingValueProvider
{
	private static final Logger LOG = Logger.getLogger(MerchandiseProductReviewAverageRatingValueProvider.class);

	@Override
	protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty,
			final LanguageModel language, final Object value)
	{
		List<String> rangeNameList = null;
		try
		{
			rangeNameList = getRangeNameList(indexedProperty, value);
		}
		catch (final FieldValueProviderException e)
		{
			LOG.error("Could not get Range value", e);
		}
		String rangeName = null;
		if (CollectionUtils.isNotEmpty(rangeNameList))
		{
			rangeName = rangeNameList.get(0);
		}
		final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty,
				language == null ? null : language.getIsocode());
		final Object valueToPass = (rangeName == null ? value : rangeName);
		for (final String fieldName : fieldNames)
		{
			LOG.info("field name is " + fieldName);
			fieldValues.add(new FieldValue(fieldName, valueToPass));
		}
	}
}

































/*
 * extends AbstractPropertyFieldValueProvider implements Serializable, FieldValueProvider {
 *
 * Logger LOG = Logger.getLogger(FilterBasedOnEnumProvider.class);
 *
 * @SuppressWarnings("deprecation")
 *
 * @Override public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty
 * indexedProperty, final Object model) throws FieldValueProviderException { // YTODO Auto-generated method stub
 *
 * if (model instanceof ProductModel) { final ProductModel product = (ProductModel) model;
 *
 * LOG.info("product++++++++++++++++++++++++++++" + product);
 *
 *
 * final Collection<FieldValue> fieldValues = new ArrayList<FieldValue>();
 *
 * if (product.getStatus() != null) { final String status = product.getStatus().getCode(); LOG.info("Status+++" +
 * status); fieldValues.add(new FieldValue(indexedProperty.getName(), status)); }
 *
 * LOG.info("Field Values=======>>" + fieldValues); return fieldValues; } else { throw new
 * FieldValueProviderException("Field Value Exception ++++++++++"); }
 *
 * } }
 */





























/*
 * ProductReviewAverageRatingValueProvider { private static final Logger LOG =
 * Logger.getLogger(MerchandiseProductReviewAverageRatingValueProvider.class);
 *
 * @Override protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty,
 * final LanguageModel language, final Object value) { List<String> rangeNameList = null; try { rangeNameList =
 * getRangeNameList(indexedProperty, value); } catch (final FieldValueProviderException e) {
 * LOG.error("Could not get Range value", e); } String rangeName = null; if (CollectionUtils.isNotEmpty(rangeNameList))
 * { rangeName = rangeNameList.get(0); } final Collection<String> fieldNames =
 * getFieldNameProvider().getFieldNames(indexedProperty, language == null ? null : language.getIsocode()); final Object
 * valueToPass = (rangeName == null ? value : rangeName); for (final String fieldName : fieldNames) {
 * fieldValues.add(new FieldValue(fieldName, valueToPass)); } } }
 */


















































/*
 * extends AbstractPropertyFieldValueProvider implements FieldValueProvider, Serializable { private FieldNameProvider
 * fieldNameProvider; final Logger LOG = Logger.getLogger(FilterBasedOnEnumProvider.class);
 *
 *
 * @Override public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty
 * indexedProperty, final Object model) throws FieldValueProviderException { final ApparelProductModel apparelModel =
 * getApparelProductModel(model); if (apparelModel == null) { return Collections.emptyList(); }
 *
 * final List<ProdStatus> prodStatus = (List<ProdStatus>) apparelModel.getStatus(); LOG.info("Product status ====> " +
 * prodStatus);
 *
 * if (prodStatus != null && !prodStatus.isEmpty()) { final Collection<FieldValue> fieldValues = new
 * ArrayList<FieldValue>(); for (final ProdStatus prodStat : prodStatus) { fieldValues.addAll(createFieldValue(prodStat,
 * indexedProperty)); } LOG.info("ADDED Field values ====> " + fieldValues); return fieldValues; } else { return
 * Collections.emptyList(); } }
 *
 * protected List<FieldValue> createFieldValue(final ProdStatus prodStatus, final IndexedProperty indexedProperty) {
 * final List<FieldValue> fieldValues = new ArrayList<FieldValue>(); final Object value = prodStatus.getCode(); final
 * Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, null); for (final String fieldName :
 * fieldNames) { fieldValues.add(new FieldValue(fieldName, value)); } LOG.info("CREATED values ====> " + fieldValues +
 * "====" + fieldNames + "===" + value); return fieldValues; }
 *
 * protected ApparelProductModel getApparelProductModel(Object model) {
 *
 * if (model instanceof ApparelSizeVariantProductModel) { final ApparelSizeVariantProductModel sizeModel =
 * (ApparelSizeVariantProductModel) model; model = sizeModel.getBaseProduct(); }
 *
 * if (model instanceof ApparelStyleVariantProductModel) { final ApparelStyleVariantProductModel styleModel =
 * (ApparelStyleVariantProductModel) model; model = styleModel.getBaseProduct(); }
 *
 * if (model instanceof ApparelProductModel) { return (ApparelProductModel) model; } else { return null; } }
 *
 * @Required public void setFieldNameProvider(final FieldNameProvider fieldNameProvider) { this.fieldNameProvider =
 * fieldNameProvider; }
 *
 * }
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */



// My own Logic

/*
 * public class FilterBasedOnEnumProvider extends AbstractPropertyFieldValueProvider implements Serializable,
 * FieldValueProvider {
 *
 * @SuppressWarnings("deprecation")
 *
 * @Override public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty
 * indexedProperty, final Object model) throws FieldValueProviderException { // YTODO Auto-generated method stub
 *
 *
 * if (model instanceof ProductModel) { final ProductModel product = (ProductModel) model;
 * LOG.info("product++++++++++++++++++++++++++++" + product);
 *
 *
 * final Collection<FieldValue> fieldValues = new ArrayList<FieldValue>();
 *
 * if (product.getStatus() != null) { final String status = product.getStatus().getCode(); LOG.info("Status+++" +
 * status); fieldValues.add(new FieldValue(indexedProperty.getName(), status)); }
 *
 * LOG.info("Field Values=======>>" + fieldValues); return fieldValues;
 *
 * }
 *
 * else { throw new FieldValueProviderException("Field Value Exception ++++++++++");
 *
 * }
 *
 * }
 *
 *
 * }
 *
 *
 */