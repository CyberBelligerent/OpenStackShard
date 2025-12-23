package com.rahman.openstackshard.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

import com.rahman.arctic.shard.shards.ShardProviderUICreation;
import com.rahman.arctic.shard.shards.UIField;
import com.rahman.openstackshard.objects.OpenStackProviderItem;

public class ObtainFlavors extends ShardProviderUICreation<OSClientV3, OpenStackProviderItem> {

	@UIField(key = "flavorId", label = "Openstack Flavor")
	public CompletableFuture<List<OpenStackProviderItem>> returnResult() {
		return CompletableFuture.supplyAsync(() -> {
            List<OpenStackProviderItem> images = new ArrayList<>();
            List<? extends Flavor> osImages = OSFactory.clientFromToken(getClient().getToken()).compute().flavors().list();
            osImages.forEach(e -> {
                images.add(new OpenStackProviderItem(e.getId(), e.getName()));
            });
            return images;
        });
	}
	
}
