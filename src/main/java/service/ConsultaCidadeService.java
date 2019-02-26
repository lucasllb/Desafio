package service;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.CidadeRepository;
import model.Cidade;

@Service
public class ConsultaCidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public void alimentaBanco() throws ParseException, FileNotFoundException, IOException {
		ConsultaCidadeService ccs = new ConsultaCidadeService();
		ccs.carregaModeloCidade();
	}
	
	public void carregaModeloCidade() throws FileNotFoundException, IOException {
        List<String[]> listaRegistros = new ArrayList<String[]>();
        File arquivoCSV = new File("C:\\cidades.csv");
        FileReader fr = new FileReader(arquivoCSV);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            String registro[] = linha.split(",");
            listaRegistros.add(registro);
            Cidade cidade = new Cidade(listaRegistros);
            cidadeRepository.save(cidade);
            listaRegistros.remove(registro);
        }
    }
	
}
