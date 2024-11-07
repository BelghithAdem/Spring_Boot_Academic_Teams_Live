package com.firstproject.first_project.Services;


import com.firstproject.first_project.model.Provider;
import com.firstproject.first_project.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Optional<Provider> getProviderById(Long id) {
        return providerRepository.findById(id);
    }

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(Long id, Provider providerDetails) {
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new RuntimeException("Provider not found"));
        provider.setMatricule(providerDetails.getMatricule());
        provider.setService(providerDetails.getService());
        provider.setCompany(providerDetails.getCompany());
        provider.setProduct(providerDetails.getProduct());
        return providerRepository.save(provider);
    }

    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }
}
