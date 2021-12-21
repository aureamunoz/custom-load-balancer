package org.acme.provider;

import io.smallrye.mutiny.Uni;
import io.smallrye.stork.DefaultServiceInstance;
import io.smallrye.stork.LoadBalancer;
import io.smallrye.stork.NoServiceInstanceFoundException;
import io.smallrye.stork.ServiceDiscovery;
import io.smallrye.stork.ServiceInstance;
import io.smallrye.stork.spi.ServiceInstanceIds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CustomLoadBalancer implements LoadBalancer {

    private final static String BUSSINESS_LABEL = "my-label";


    public CustomLoadBalancer() {
    }


    @Override
    public ServiceInstance selectServiceInstance(Collection<ServiceInstance> serviceInstances) {
        if (serviceInstances.isEmpty()) {
            throw new NoServiceInstanceFoundException("No services found.");
        }
        List<ServiceInstance> modifiableList = new ArrayList<>(serviceInstances);
        return modifiableList.stream().filter(serviceInstance -> serviceInstance.getLabels().containsKey(BUSSINESS_LABEL)).findFirst().get();
    }
}
