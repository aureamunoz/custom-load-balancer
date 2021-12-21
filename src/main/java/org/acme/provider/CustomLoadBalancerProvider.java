package org.acme.provider;

import io.smallrye.stork.LoadBalancer;
import io.smallrye.stork.ServiceDiscovery;
import io.smallrye.stork.config.LoadBalancerConfig;
import io.smallrye.stork.config.ServiceConfig;
import io.smallrye.stork.config.ServiceDiscoveryConfig;
import io.smallrye.stork.spi.LoadBalancerProvider;
import io.smallrye.stork.spi.ServiceDiscoveryProvider;

public class CustomLoadBalancerProvider implements LoadBalancerProvider {
    @Override
    public String type() {
        return "custom";
    }

    @Override
    public LoadBalancer createLoadBalancer(LoadBalancerConfig config, ServiceDiscovery serviceDiscovery) {
        return new CustomLoadBalancer();
    }
}
