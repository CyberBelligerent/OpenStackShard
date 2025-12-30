package com.rahman.openstackshard.ui;

import java.util.ArrayList;
import java.util.List;

import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

import com.rahman.arctic.shard.shards.ShardProviderUICreation;
import com.rahman.arctic.shard.shards.UIField;
import com.rahman.openstackshard.objects.OpenStackProviderItem;

public class ObtainFlavors extends ShardProviderUICreation<OSClientV3, List<OpenStackProviderItem>> {

	@UIField(key = "flavorId", label = "Openstack Flavor")
	public List<OpenStackProviderItem> returnResult(OSClientV3 client) {
		List<OpenStackProviderItem> flavors = new ArrayList<>();
        List<? extends Flavor> osFlavors = OSFactory.clientFromToken(client.getToken()).compute().flavors().list();
        osFlavors.forEach(e -> {
            flavors.add(new OpenStackProviderItem(e.getId(), e.getName()));
        });
        return flavors;
	}
	
}
