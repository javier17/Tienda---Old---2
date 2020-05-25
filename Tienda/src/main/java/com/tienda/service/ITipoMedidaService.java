package com.tienda.service;

import java.util.List;


import com.tienda.model.TipoMedida;

public interface ITipoMedidaService {

	void guardar(TipoMedida tipoMedida);

	List<TipoMedida> buscarTodas();

	TipoMedida buscarPorId(Integer idTipoMedida);

}
