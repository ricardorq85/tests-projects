package forex.genetic.entities.mongodb;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import forex.genetic.entities.TendenciaParaOperar;

public class MongoTendenciaParaOperarHelper {

	public static Map<String, Object> toMap(TendenciaParaOperar obj) {
		Map<String, Object> objectMap = new HashMap<String, Object>();

		objectMap.put("tipoExportacion", obj.getTipoExportacion());
		objectMap.put("periodo", obj.getPeriod());
		objectMap.put("tipoTendencia", obj.getTipoTendencia());
		objectMap.put("tipoOperacion", obj.getTipoOperacion().name());
		objectMap.put("fechaBase", obj.getFechaBase());
		objectMap.put("fechaTendencia", obj.getFechaTendencia());
		objectMap.put("vigenciaLower", obj.getVigenciaLower());
		objectMap.put("vigenciaHigher", obj.getVigenciaHigher());
		objectMap.put("precioCalculado", obj.getPrecioCalculado());
		objectMap.put("stopApertura", obj.getStopApertura());
		objectMap.put("limitApertura", obj.getLimitApertura());
		objectMap.put("takeProfit", obj.getTp());
		objectMap.put("stopLoss", obj.getSl());
		objectMap.put("loteCalculado", obj.getLoteCalculado());
		if (obj.getRegresion() != null) {
			objectMap.put("tiempoTendencia", obj.getRegresion().getTiempoTendencia());
			objectMap.put("r2", obj.getRegresion().getR2());
			objectMap.put("pendiente", obj.getRegresion().getPendiente());
			objectMap.put("desviacion", obj.getRegresion().getDesviacion());
			objectMap.put("r2Filtrada", obj.getRegresionFiltrada().getR2());
			objectMap.put("minPrecio", obj.getRegresion().getMinPrecio());
			objectMap.put("maxPrecio", obj.getRegresion().getMaxPrecio());
			objectMap.put("cantidad", obj.getRegresion().getCantidad());
		}
		if (obj.getRegresionFiltrada() != null) {
			objectMap.put("pendienteFiltrada", obj.getRegresionFiltrada().getPendiente());
			objectMap.put("desviacionFiltrada", obj.getRegresionFiltrada().getDesviacion());
			objectMap.put("cantidadFiltrada", obj.getRegresionFiltrada().getCantidad());
		}
		objectMap.put("fecha", new Date().getTime());
		objectMap.put("idEjecucion", obj.getIdEjecucion());
		objectMap.put("activa", obj.getActiva());

		return objectMap;
	}

}
