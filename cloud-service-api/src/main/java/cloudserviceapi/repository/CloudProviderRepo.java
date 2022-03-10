package cloudserviceapi.repository;

import cloudserviceapi.domain.CloudProvider;
import cloudserviceapi.domain.CloudService;
import org.springframework.data.repository.CrudRepository;

/**
 * @author agj017@gmail.com
 * @since 2022/03/10
 */
public interface CloudProviderRepo  extends CrudRepository<CloudProvider, Long> {
}
