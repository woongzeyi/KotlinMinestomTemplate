import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.instance.Chunk
import net.minestom.server.instance.ChunkGenerator
import net.minestom.server.instance.ChunkPopulator
import net.minestom.server.instance.batch.ChunkBatch
import net.minestom.server.instance.block.Block
import net.minestom.server.world.biomes.Biome
import java.util.*

fun main() {
    // Initialization
    val minecraftServer = MinecraftServer.init()

    val instanceManager = MinecraftServer.getInstanceManager()
    // Create the instance
    val instanceContainer = instanceManager.createInstanceContainer()
    // Set the ChunkGenerator
    instanceContainer.chunkGenerator = GeneratorDemo()

    // Add an event callback to specify the spawning instance (and the spawn position)
    val globalEventHandler = MinecraftServer.getGlobalEventHandler()
    globalEventHandler.addListener(PlayerLoginEvent::class.java) { event ->
        val player = event.player
        event.setSpawningInstance(instanceContainer)
        player.respawnPoint = Pos(0.0, 42.0, 0.0)
    }

    // Start the server on port 25565
    minecraftServer.start("0.0.0.0", 25565)
}

class GeneratorDemo : ChunkGenerator {
    override fun generateChunkData(batch: ChunkBatch, chunkX: Int, chunkZ: Int) {
        // Set chunk blocks
        for (x in 0..Chunk.CHUNK_SIZE_X)
            for (z in 0..Chunk.CHUNK_SIZE_Z) {
                for (y in 0..40) {
                    batch.setBlock(x, y, z, Block.STONE)
                }
            }
    }

    override fun fillBiomes(biomes: Array<out Biome>, chunkX: Int, chunkZ: Int) {
        Arrays.fill(biomes, Biome.PLAINS)
    }

    override fun getPopulators(): MutableList<ChunkPopulator>? {
        return null
    }
}
