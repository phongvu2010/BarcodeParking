package ga.hunterdo.barcodeparking.config;

//import static java.util.concurrent.TimeUnit.SECONDS;

//import javax.cache.CacheManager;
//import javax.cache.configuration.MutableConfiguration;
//import javax.cache.expiry.Duration;
//import javax.cache.expiry.TouchedExpiryPolicy;

//import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
//import org.springframework.stereotype.Component;

public class CacheConfig {
//	@Component
//	public static class CachingSetup implements JCacheManagerCustomizer {
//		@Override
//		public void customize(CacheManager cacheManager) {
//			cacheManager.createCache("userCache", new MutableConfiguration<>()
//					.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 600)))
//					.setStoreByValue(false)
//					.setStatisticsEnabled(true));
//
//			cacheManager.createCache("countByCode", new MutableConfiguration<>()
//					.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 3600)))
//					.setStoreByValue(false)
//					.setStatisticsEnabled(true));
//
//			cacheManager.createCache("orderCache", new MutableConfiguration<>()
//					.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 3600)))
//					.setStoreByValue(false)
//					.setStatisticsEnabled(true));
//
//			cacheManager.createCache("codeCache", new MutableConfiguration<>()
//					.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 3600)))
//					.setStoreByValue(false)
//					.setStatisticsEnabled(true));
//		}
//	}
}