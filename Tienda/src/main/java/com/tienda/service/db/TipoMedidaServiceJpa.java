package com.tienda.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.model.TipoMedida;
import com.tienda.repository.ITipoMedidaRepository;
import com.tienda.service.ITipoMedidaService;

@Service
public class TipoMedidaServiceJpa implements ITipoMedidaService{
	
	@Autowired
	private ITipoMedidaRepository tipoMedidaRepository;

	@Override
	public void guardar(TipoMedida tipoMedida) {
		tipoMedidaRepository.save(tipoMedida);
	}

	@Override
	public List<TipoMedida> buscarTodas() {
		return tipoMedidaRepository.findAll();
	}

	@Override
	public TipoMedida buscarPorId(Integer idTipoMedida) {
		Optional<TipoMedida> optional = tipoMedidaRepository.findById(idTipoMedida);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
}
